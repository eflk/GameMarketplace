package adapters;

import java.rmi.RemoteException;

import abstracts.ICitizenshipValidatorManager;
import concrete.Helper;
import entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements ICitizenshipValidatorManager {

	@SuppressWarnings("deprecation")
	@Override
	public boolean validateCitizenship(Customer customer) {
		
		KPSPublicSoap kpsPublicSoap = new KPSPublicSoapProxy();
		
		try {
			return kpsPublicSoap.TCKimlikNoDogrula(Long.parseLong(customer.citizenIdNumber), customer.firstName,
					customer.lastName, customer.birthDate.getYear()+1900);
		} catch (RemoteException e) {
			if (Helper.PrintStactTraceAllowed())
				e.printStackTrace();
		}
		return false;
	}
}
