package com.cmu.designpatterns;


public class Converter2 implements IConverter {

	private String settingInformation;
    private String conversionDescriptorFile;

    @Override
	public void init(String conversionTemplateFileName, String serverName) {
		System.out.println("C2 constructor");
		this.conversionDescriptorFile = conversionTemplateFileName;
		this.settingInformation = serverName;
		//do initializations
	}

	
	/* (non-Javadoc)
	 * @see com.cmu.designpatterns.IConverter#getIHDSRoot(java.lang.String, boolean)
	 */
	@Override
	public String getIHDSRoot(String wb, boolean validate) {
		System.out.println("C2 getIHDSRoot(String wb, boolean validate)");
		doSomeOtherStuff(wb);
		
		if (validate) {
			System.out.println("C2 Validating ihds before returning it");
		}		
		return "C2 IHDS-ul validat";
	}
	
	/* (non-Javadoc)
	 * @see com.cmu.designpatterns.IConverter#getIHDSRoot(java.lang.String)
	 */
	@Override
	public String getIHDSRoot(String workbook) {
		System.out.println("C2 getIHDSRoot(String workbook)");
		return getIHDSRoot(workbook, true);
	}
	
	private void doSomeOtherStuff(String wb) {
		System.out.println("C2 doSomeOtherStuff for workbook = " + wb);
	}


	@Override
	public void printClassDetails() {
		System.out.println(">>>>"+ this.getClass());
		
	}

}