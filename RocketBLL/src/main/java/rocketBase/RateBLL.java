package rocketBase;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();

	public static double getRate(int GivenCreditScore) throws RateException {
		List<RateDomainModel> rateArray = new ArrayList<>();
		double rate = 0;
		rateArray = RateDAL.getAllRates();
		RateDomainModel maximum = new RateDomainModel();
		for (RateDomainModel r : rateArray) {
			if (r.getiMinCreditScore() <= GivenCreditScore) {
				maximum = r;
			}
		}
		rate = maximum.getdInterestRate();
		if (rate == 0) {
			throw new RateException(maximum);
		}
		return rate;

	}

	// TODO - RocketBLL RateBLL.getPayment
	// how to use:
	// https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html

	public static double getPayment(double r, double n, double p, double f, boolean t) {
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
