package com.intuit.assignment.receivers;

import com.intuit.assignment.application.ServiceContext;
import com.intuit.assignment.util.ScannerUtil;

public interface IReceiver {

	public static final ScannerUtil sc = ScannerUtil.getInstance();

	void action(ServiceContext serviceContext) throws Exception;

}
