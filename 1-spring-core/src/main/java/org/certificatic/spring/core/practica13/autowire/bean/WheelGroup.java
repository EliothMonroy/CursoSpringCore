package org.certificatic.spring.core.practica13.autowire.bean;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class WheelGroup {
	private List<Wheel> wheelList;

	public WheelGroup() {
	}

	public WheelGroup(List<Wheel> wheelList) {
		this.wheelList = wheelList;
	}

	@Override
	public String toString() {
		String string = "WheelGroup [\n" + "\t\twheelList: List<Llanta>["
				+ this.wheelList.size() + "] [";

		if (wheelList == null)
			wheelList = new ArrayList<Wheel>();

		for (Wheel ll : wheelList) {

			string += "\n\t\t\t" + ll.toString();

		}
		string += "\n\t\t" + "]";

		return string;
	}
}
