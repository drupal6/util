package excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/** 
	*
	* @author Gene
	*
*/
public class Main {

	public static void main(String[] args) {
		OperatingExcel oe = new OperatingExcel();
		List<Map<String, String>> ybShopList = oe.readExcelAsList("D:/work/战狼/数值输出/配置表/t_base_config.xlsx", "t_base_config", 3, 4);
		Map<String, String> contain = new HashMap<String, String>();
		for(Map<String, String> map : ybShopList) {
			String str = "";
			String name = "";
			String title = "(";
			String value = "(";
			int count = 0;
			for(Entry<String, String> entry : map.entrySet()) {
				if(entry.getKey().equals("config_name")) {
					name = entry.getValue().toLowerCase();
				}
				str += (entry.getValue() + "||");
				boolean isInte = (entry.getKey().equals("config_id") || entry.getKey().equals("is_client")) ? true : false;
				if(count > 0) {
					title += ", `"+entry.getKey()+"`";
					if(isInte) {
						Double d = new Double(entry.getValue());
						if(d == d.intValue()) {
							value += ", "+d.intValue();
						} else {
							value += ", "+entry.getValue();
						}
					} else {
						value += ", '"+entry.getValue()+"'";
					}
				} else {
					title += "`"+entry.getKey()+"`";
					if(isInte) {
						value += entry.getValue();
					} else {
						value += "'"+entry.getValue()+"'";
					}
					count++;
				}
			}
			title += ")";
			value += ")";
			System.out.println("INSERT INTO `t_base_config` "+title+" VALUES "+value+";");
			if(contain.containsKey(name)) {
				System.out.println("old:" + contain.get(name));
				System.out.println("new:" + str);
			} else {
				contain.put(name, str);
			}
		}
	}
}
