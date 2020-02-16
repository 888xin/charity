package com.lhx.charity.service;

import com.lhx.charity.entity.User;
import com.lhx.charity.respository.UserRepository;
import com.lhx.charity.utils.Constants;
import com.lhx.charity.utils.ContentUtils;
import com.lhx.charity.utils.MD5Utils;
import com.lhx.charity.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Result<User> login(User user) {
        Result<User> result = new Result<>();
        if (ContentUtils.isValidate(user.getName(), user.getPassword())) {
            result.setCode(Constants.BAD);
            result.setMsg("必填字段有空");
            return result;
        }
        User userCondition = new User();
        userCondition.setName(user.getName());
        String dbPwd = MD5Utils.getMD5(user.getPassword());
        userCondition.setPassword(dbPwd);
        Optional<User> userOptional = userRepository.findOne(Example.of(userCondition));
        if (userOptional.isPresent()){
            result.setCode(Constants.OK);
            result.setMsg("登录成功");
            result.setData(userOptional.get());
            return result;
        } else {
            result.setCode(Constants.BAD);
            result.setMsg("账号或者密码错误");
        }
        return result;
    }

    @Override
    public Result<User> add(User user) {
        Result<User> result = new Result<>();
        if (ContentUtils.isValidate(user.getEmail(), user.getName(), user.getPassword())) {
            result.setCode(Constants.BAD);
            result.setMsg("必填字段有空");
            return result;
        }
        User userCondition = new User();
        userCondition.setName(user.getName());
        long count = userRepository.count(Example.of(userCondition));
        if (count > 0){
            result.setCode(Constants.BAD);
            result.setMsg("该用户已经存在");
            return result;
        }
        String dbPwd = MD5Utils.getMD5(user.getPassword());
        user.setPassword(dbPwd);
        user.setCreateTime(new Date());
        User newUser = userRepository.save(user);
        result.setData(newUser);
        result.setCode(Constants.OK);
        result.setMsg("注册成功");
        return result;
    }

    @Override
    public Result<User> updatePassword(User user) {
        return null;
    }


//    @Override
//    public Result<Trader> login(Trader trader, HttpServletResponse response) {
//        Result<Trader> result = new Result<>();
//        if (ContentUtils.isValidate(trader.getMobile(), trader.getPassword())){
//            result.setCode(Constants.BAD);
//            result.setMsg("必填字段有空");
//            return result;
//        }
//        if (traderConfig.getInitPwd().equals(trader.getPassword())){
//            result.setCode(Constants.BAD);
//            result.setMsg("需要修改初始密码");
//            return result;
//        }
//        String dbPassword = MD5Utils.getMD5(trader.getPassword());
//        Trader traderConfidition = new Trader();
//        traderConfidition.setMobile(trader.getMobile());
//        traderConfidition.setPassword(dbPassword);
//        traderConfidition.setIsDel(Boolean.FALSE);
//        Optional<Trader> traderOptional = traderRepository.findOne(Example.of(traderConfidition));
//        result.setCode(Constants.BAD);
//        result.setMsg("账号或密码错误");
//        traderOptional.ifPresent( t -> {
//            result.setCode(Constants.OK);
//            result.setMsg("成功登录");
//            t.setPassword(null);
//            //把用户存储到Redis里面，过期时间为5个小时
//            String userKey = t.getMobile() + t.getPassword() + new Date().getTime();
//            String accessToken = MD5Utils.getSHA256(userKey);
//            //把用户存储到Redis里面，过期时间为5天
//            redisTemplate.opsForValue().set(Constants.REDIS_TOKEN2+accessToken, t, Constants.REDIS_EXPIRE_DAYS, TimeUnit.DAYS);
//            t.setAccessToken(accessToken);
//            response.setHeader("Authorization", accessToken);
//            result.setData(t);
//        });
//
//        return result;
//    }


//    @Override
//    public Result<Trader> updatePassword(Trader trader) {
//        Result<Trader> result = new Result<>();
//        if (ContentUtils.isValidate(trader.getPassword(), trader.getAfterPassword(), trader.getMobile())){
//            result.setCode(Constants.BAD);
//            result.setMsg("必填字段有空");
//            return result;
//        }
//        //查找用户是否存在
//        Trader trader2 = new Trader();
//        trader2.setMobile(trader.getMobile());
//        trader2.setIsDel(Boolean.FALSE);
//        String dbPassword = MD5Utils.getMD5(trader.getPassword());
//        trader2.setPassword(dbPassword);
//        Optional<Trader> traderOptionalOld = traderRepository.findOne(Example.of(trader2));
//        result.setCode(Constants.BAD);
//        result.setMsg("该用户不存在");
//        traderOptionalOld.ifPresent(t -> {
//            String dbPassword2 = MD5Utils.getMD5(trader.getAfterPassword());
//            t.setPassword(dbPassword2);
//            traderRepository.saveAndFlush(t);
//            result.setCode(Constants.OK);
//            result.setMsg("修改成功");
//
//            //删除Redis里面的token数据
//            Set<String> userKeys = redisTemplate.keys(Constants.REDIS_TOKEN2+"*");
//            if (userKeys != null && userKeys.size() > 0){
//                List<String> userKeysList = new ArrayList<>(userKeys);
//                List<Trader> traderList = redisTemplate.opsForValue().multiGet(userKeysList);
//                for (int i = 0; i < traderList.size(); i++) {
//                    Trader trader1 = traderList.get(i);
//                    if (trader1.getFdId() == t.getFdId().intValue()){
//                        redisTemplate.delete(userKeysList.get(i));
//                        break;
//                    }
//                }
//            }
//        });
//
//        return result;
//    }
//
//    @Override
//    public Result<List<TransportVo>> transport(String startDate, String endDate, String traderName) {
//        Result<List<TransportVo>> result = new Result<>();
//        List<TransportVo> list = new ArrayList<>();
//        result.setData(list);
//        result.setCode(Constants.OK);
//        result.setMsg("货款支付记录表");
//
//
//        //查询该经销商有效的合同
//        DataSourceContextHolder.setDBType(SourceEnum.SNAPSHOT);
//        String sql1 = "SELECT * FROM sale_contract_info where status=0 and customer_name='"+traderName+"'";
//        List<Map<String, Object>> maps = JdbcUtils.getData(sql1);
//        if (maps.size() > 0){
//            Map<String, TransportVo> map2 = new HashMap<>();
//            for (Map<String, Object> map : maps) {
//                Long fdId = (Long) map.get("fd_id");
//                String lb = (String) map.get("forest_class_name");
//                String contractCode = (String) map.get("contract_code");
//                BigDecimal mainPredict = (BigDecimal) map.get("main_predict");
//                if (mainPredict == null) mainPredict = BigDecimal.ZERO;
//                BigDecimal vicePredict = (BigDecimal) map.get("vice_predict");
//                if (vicePredict == null) vicePredict = BigDecimal.ZERO;
//                TransportVo transportVo = map2.get(contractCode);
//                if (transportVo == null){
//                    transportVo = new TransportVo();
//                    transportVo.setFdId(fdId);
//                    transportVo.setContractCode(contractCode);
//                    transportVo.setAllLb(lb);
//                    transportVo.setMainPredict(mainPredict);
//                    transportVo.setVicePredict(vicePredict);
//                    map2.put(contractCode, transportVo);
//                } else {
//                    transportVo.setAllLb(transportVo.getAllLb() + "," + lb);
//                    transportVo.setMainPredict(transportVo.getMainPredict().add(mainPredict));
//                    transportVo.setVicePredict(transportVo.getVicePredict().add(vicePredict));
//                }
//
//            }
//            for (String s : map2.keySet()) {
//                list.add(map2.get(s));
//            }
//            //拉运情况查询
//            for (TransportVo transportVo : list) {
//                String sql2 = "SELECT * FROM freight_volumn where contract_code='"+transportVo.getContractCode()+"' order by fd_date";
//                List<Map<String, Object>> maps2 = JdbcUtils.getData(sql2);
//                if (maps2.size() > 0){
//                    for (Map<String, Object> map : maps2) {
//                        //wood_number 正材
//                        BigDecimal woodNumber = (BigDecimal) map.get("wood_number");
//                        if (woodNumber == null) woodNumber = BigDecimal.ZERO;
//                        transportVo.setAlreadyTransport(transportVo.getAgreedTransport().add(woodNumber));
//
//                        //firewood_number 薪材
//                        BigDecimal firewoodNumber = (BigDecimal) map.get("firewood_number");
//                        if (firewoodNumber == null) firewoodNumber = BigDecimal.ZERO;
//                        transportVo.setViceAlreadyTransport(transportVo.getViceAlreadyTransport().add(firewoodNumber));
//
//                        //number 可拉运量
//                        BigDecimal hasNumber = (BigDecimal) map.get("number");
//                        if (hasNumber == null) hasNumber = BigDecimal.ZERO;
//
//                        //wood_type 采种
//                        String woodType = (String) map.get("wood_type");
//                        //剩余可拉运量
//                        if ("正材".equals(woodType)){
//                            transportVo.setSurplusTransport(transportVo.getSurplusTransport().add(hasNumber.subtract(woodNumber)));
//                        } else if ("薪材".equals(woodType)){
//                            transportVo.setViceSurplusTransport(transportVo.getViceSurplusTransport().add(hasNumber.subtract(firewoodNumber)));
//                        }
//
//
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public Result<List<PayMentVoList>> payList(String startDate, String endDate, String traderName) {
//        Result<List<PayMentVoList>> result = new Result<>();
//        List<PayMentVoList> list = new ArrayList<>();
//        result.setData(list);
//        result.setCode(Constants.OK);
//        result.setMsg("货款支付记录表");
//
//
//        //查询该经销商有效的合同
//        DataSourceContextHolder.setDBType(SourceEnum.SNAPSHOT);
//        String sql1 = "SELECT * FROM sale_contract_info where status=0 and customer_name='"+traderName+"'";
//        List<Map<String, Object>> maps = JdbcUtils.getData(sql1);
//        if (maps.size() > 0){
//            Map<String, PayMentVoList> map2 = new HashMap<>();
//            for (Map<String, Object> map : maps) {
//                String lb = (String) map.get("forest_class_name");
//                String contractCode = (String) map.get("contract_code");
//                PayMentVoList payMentVoList = map2.get(contractCode);
//                if (payMentVoList == null){
//                    payMentVoList = new PayMentVoList();
//                    payMentVoList.setContractCode(contractCode);
//                    payMentVoList.setAllLb(lb);
//                    map2.put(contractCode, payMentVoList);
//                } else {
//                    payMentVoList.setAllLb(payMentVoList.getAllLb() + "," + lb);
//                }
//
//            }
//            for (String s : map2.keySet()) {
//                list.add(map2.get(s));
//            }
//            //遍历，查询货款支付
//            for (PayMentVoList payMentVoList : list) {
//                String sql2 = "SELECT * FROM `freight_volumn` where contract_code='"+payMentVoList.getContractCode()+"' order by fd_date";
//                List<Map<String, Object>> maps2 = JdbcUtils.getData(sql2);
//                if (maps2.size() > 0){
//                    List<PayMentVo> payMentVos = new ArrayList<>();
//                    PayMentVo prePayMentVo = null;
//                    for (Map<String, Object> map : maps2) {
//                        //贷款金额
//                        BigDecimal freightAmount = (BigDecimal) map.get("freight_amount");
//                        Date fdDate = (Date) map.get("fd_date");
//                        if (prePayMentVo != null && prePayMentVo.getPayDate().compareTo(fdDate) == 0){
//                            //相同日期，统计累计，不添加到list中
//                            prePayMentVo.setPayLoan(prePayMentVo.getPayLoan().add(freightAmount));
//                            prePayMentVo.setAddPayLoan(prePayMentVo.getAddPayLoan().add(freightAmount));
//                        } else {
//                            PayMentVo payMentVo = new PayMentVo();
//
//                            Long fdId = (Long) map.get("fd_id");
//                            payMentVo.setFdId(fdId);
//                            payMentVo.setPayLoan(freightAmount);
//                            payMentVo.setPayDate(fdDate);
//                            if (prePayMentVo == null){
//                                payMentVo.setAddPayLoan(freightAmount);
//                            } else {
//                                payMentVo.setAddPayLoan(prePayMentVo.getAddPayLoan().add(freightAmount));
//                            }
//                            prePayMentVo = payMentVo;
//                            payMentVos.add(payMentVo);
//                        }
//                    }
//                    payMentVoList.setPayMentVos(payMentVos);
//                }
//            }
//        }
//
//
//        return result;
//    }
//
//    @Override
//    public Result<List<CarVoList>> carList(String traderName) {
//        Result<List<CarVoList>> result = new Result<>();
//        List<CarVoList> list = new ArrayList<>();
//        result.setData(list);
//        result.setCode(Constants.OK);
//        result.setMsg("拉运车辆信息列表");
//        //查询该经销商有效的合同
//        DataSourceContextHolder.setDBType(SourceEnum.SNAPSHOT);
//        //String sql1 = "SELECT DISTINCT(contract_code) FROM `sale_contract_info` where status=0 and contractor='"+traderName+"'";
//        String sql1 = "SELECT * FROM sale_contract_info where status=0 and customer_name='"+traderName+"'";
//        List<Map<String, Object>> maps = JdbcUtils.getData(sql1);
//        if (maps.size() > 0){
//            Map<String, CarVoList> map2 = new HashMap<>();
//            for (Map<String, Object> map : maps) {
//                String lb = (String) map.get("forest_class_name");
//                String contractCode = (String) map.get("contract_code");
//                CarVoList carVoList = map2.get(contractCode);
//                if (carVoList == null){
//                    carVoList = new CarVoList();
//                    carVoList.setContractCode(contractCode);
//                    carVoList.setAllLb(lb);
//                    map2.put(contractCode, carVoList);
//                } else {
//                    carVoList.setAllLb(carVoList.getAllLb() + "," + lb);
//                }
//
//            }
//            for (String s : map2.keySet()) {
//                list.add(map2.get(s));
//            }
//            //遍历，查询具体车辆信息
//            for (CarVoList carVoList : list) {
//                String sql2 = "SELECT * FROM car_info where is_del=false and contract_code='"+carVoList.getContractCode()+"'";
//                List<Map<String, Object>> maps2 = JdbcUtils.getData(sql2);
//                if (maps2.size() > 0){
//                    List<CarVo> carVos = new ArrayList<>();
//                    for (Map<String, Object> map : maps2) {
//                        CarVo carVo = new CarVo();
//
//                        Long fdId = (Long) map.get("fd_id");
//                        carVo.setFdId(fdId);
//
//                        String carNumber = (String) map.get("car_number");
//                        carVo.setCarNumber(carNumber);
//
//                        String contractCode = (String) map.get("contract_code");
//                        carVo.setContractCode(contractCode);
//
//                        String driverPhone = (String) map.get("driver_phone");
//                        carVo.setDriverPhone(driverPhone);
//
//                        String cardNumber = (String) map.get("card_number");
//                        carVo.setCardNumber(cardNumber);
//
//                        String driverName = (String) map.get("driver_name");
//                        carVo.setDriverName(driverName);
//
//                        Date createDate = (Date) map.get("create_date");
//                        carVo.setCreateDate(createDate);
//                        carVos.add(carVo);
//                    }
//                    carVoList.setCarVos(carVos);
//                }
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public Result<CarVo> carAdd(CarVo carVo, String traderName) {
//        Result<CarVo> result = new Result<>();
//        if (ContentUtils.isValidate(carVo.getContractCode())){
//            result.setCode(Constants.BAD);
//            result.setMsg("必填字段有空");
//            return result;
//        }
//        DataSourceContextHolder.setDBType(SourceEnum.SNAPSHOT);
//        String sql1 = "SELECT * FROM sale_contract_info where contract_code='"+carVo.getContractCode()+"'";
//        List<Map<String, Object>> maps = JdbcUtils.getData(sql1);
//        if (maps.size() > 0){
//            Map<String, Object> one = maps.get(0);
//            //经销商ID
//            Integer customerId = (Integer) one.get("customer_id");
//            //经销商名称
//            String customerName = (String) one.get("customer_name");
//
//            String sql2 = "INSERT INTO car_info(fd_id,car_number,contract_code,customer_id,customer_name,driver_phone,card_number,driver_name,is_belong_company,is_del,status,create_date) VALUES (?,?,?,?,?,?,?,?,?,?,?,NOW())";
//            long incrementId = redisTemplate.opsForValue().increment(Constants.REDIS_INCREMENT_ID,1);
//            boolean insertFlag = JdbcUtils.update(sql2, incrementId+"", carVo.getCardNumber(), carVo.getContractCode(), customerId.toString(), customerName, carVo.getDriverPhone(), carVo.getCardNumber(), carVo.getDriverName(),"0","0","0");
//            if (insertFlag){
//                result.setCode(Constants.OK);
//                result.setMsg("增加成功");
//            } else {
//                result.setCode(Constants.BAD);
//                result.setMsg("增加失败");
//            }
//        } else {
//            result.setCode(Constants.BAD);
//            result.setMsg("没有该销售合同");
//        }
//        return result;
//    }
//
//    @Override
//    public Result<CarVo> carDelete(Long fdId, String traderName) {
//        Result<CarVo> result = new Result<>();
//        if (ContentUtils.isValidate(fdId)){
//            result.setCode(Constants.BAD);
//            result.setMsg("必填字段有空");
//            return result;
//        }
//        DataSourceContextHolder.setDBType(SourceEnum.SNAPSHOT);
//        String sql = "update car_info set is_del=true where fd_id=1";
//        boolean insertFlag = JdbcUtils.update(sql,"1");
//        if (insertFlag){
//            result.setCode(Constants.OK);
//            result.setMsg("删除成功");
//        } else {
//            result.setCode(Constants.BAD);
//            result.setMsg("删除失败");
//        }
//        return result;
//    }
}
