package top.fycoding.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 构造sql where条件
 * where 1 = 1 and name = ?
 */
public class BuilderWhere {
    

    private Map<String, String> condition = new HashMap<String, String>();

    private String where = "where 1 = 1";
    private List<Object> params = new ArrayList<Object>();

    // public static void main(String[] args) {
    //     Map<String, String> condition = new HashMap<String, String>();
    //     condition.put("name", "xxx");
    //     condition.put("email", "ccc");
    //     BuilderWhere bw = new BuilderWhere(condition);
    //     System.out.println(bw.getWhere());
    //     System.out.println(bw.getParams().toArray().toString());
    // }

    public BuilderWhere(Map<String, String> condition) {
        this.condition = condition;
        this.build();
    }

    private void build() {
        StringBuilder sb = new StringBuilder(this.where);
        for(String key : condition.keySet()) {
            String value = condition.get(key);
            if(!"".equals(value)) {
                sb.append(" and " + key + " like ?");
                params.add("%" + value + "%");
            }
        }
        this.where = sb.toString();
    }

    public String getWhere() {
        return this.where;
    }

    public List<Object> getParams() {
        return this.params;
    }

}
