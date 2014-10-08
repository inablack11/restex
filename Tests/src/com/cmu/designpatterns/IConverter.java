package com.cmu.designpatterns;

public interface IConverter {

	public abstract String getIHDSRoot(String wb, boolean validate);

	public abstract String getIHDSRoot(String workbook);

	public abstract void printClassDetails();

	public abstract void init(String conversionTemplateFileName,
			String serverName);
}