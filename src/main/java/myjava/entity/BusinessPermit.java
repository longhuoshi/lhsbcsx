package myjava.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author l
 * @date 2021/6/17 15:36
 * @description
 *
 * 食品经营许可证识别
 *
 * {
 *     "sid": "aef1fb4cd8f6aac131ad7b48c7a7418e721e92e3b16024e65f50f20ffdb34cb68886979f",
 *     "data": {},
 *     "angle": 90,
 *     "height": 700,
 *     "width": 497,
 *     "orgHeight": 700,
 *     "orgWidth": 497,
 *     "prism_keyValueInfo": [
 *         {
 *             "key": "经营者名称",
 *             "value": "杭州明珍蔬菜销售有限公司",
 *             "valuePos": [],
 *             "keyProb": 100,
 *             "valueProb": 100
 *         },
 *         {
 *             "key": "社会信用代码（身份证号码）",
 *             "value": "913301105551683333",
 *             "valuePos": [],
 *             "keyProb": 100,
 *             "valueProb": 100
 *         },
 *         {
 *             "key": "法定代表人（负责人）",
 *             "value": "袁国荣",
 *             "valuePos": [],
 *             "keyProb": 99,
 *             "valueProb": 99
 *         },
 *         {
 *             "key": "住所",
 *             "value": "浙江省杭州市余杭区东湖街道余杭经济技术开发区北沙西路9号6幢",
 *             "valuePos": [],
 *             "keyProb": 100,
 *             "valueProb": 100
 *         },
 *         {
 *             "key": "经营场所",
 *             "value": "浙江省杭州市余杭区东湖街道余杭经济技术开发区北沙西路9号6幢",
 *             "valuePos": [],
 *             "keyProb": 100,
 *             "valueProb": 100
 *         },
 *         {
 *             "key": "主体业态",
 *             "value": "食品销售经营者",
 *             "valuePos": [],
 *             "keyProb": 100,
 *             "valueProb": 100
 *         },
 *         {
 *             "key": "经营项目",
 *             "value": "预包装食品(含冷藏冷冻食品)销售；散装食品(含冷藏冷冻食品)销售：保健食品销售",
 *             "valuePos": [],
 *             "keyProb": 98,
 *             "valueProb": 99
 *         },
 *         {
 *             "key": "许可证编号",
 *             "value": "JY13301840100358",
 *             "valuePos": [],
 *             "keyProb": 99,
 *             "valueProb": 99
 *         },
 *    ]
 * }
 *
 */
public class BusinessPermit implements Serializable {
    private String sid;
    private String data;
    /**
     * 经营者名称----湖州市凤凰小学
     *许可证编号----JY33305000100173
     * 签发日期----2017年09月13日
     * 格式化签发日期----20170913
     * */
    private List<Map<String,Object>> prism_keyValueInfo;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Map<String, Object>> getPrism_keyValueInfo() {
        return prism_keyValueInfo;
    }

    public void setPrism_keyValueInfo(List<Map<String, Object>> prism_keyValueInfo) {
        this.prism_keyValueInfo = prism_keyValueInfo;
    }
}
