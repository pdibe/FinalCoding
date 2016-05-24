package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {
	RateDomainModel ratedomainmodel = new RateDomainModel();

	public RateException(RateDomainModel r) {
		ratedomainmodel = r;
	}

	public RateDomainModel getratedomainmodel() {
		return (ratedomainmodel);
	}
}
