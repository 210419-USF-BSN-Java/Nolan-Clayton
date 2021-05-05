package com.revature.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.revature.daos.EmployeeDao;
import com.revature.daos.ItemDao;
import com.revature.daos.OfferDao;
import com.revature.models.Employee;
import com.revature.models.Item;
import com.revature.models.Offer;
import com.revature.util.LoggerSingelton;

public class EmployeeServices {

	public static Integer createEmployee(Employee emp) {

		LoggerSingelton.getLottger()
				.info(EmployeeStartMenuBuilder.getLoggedInEmployee().getUserName() + " registred new employee Name = "
						+ emp.getName() + " UserName = " + emp.getUserName() + " is a manager = " + emp.getManFlag());

		return EmployeeDao.add(emp);

	}

	public static Integer removeEmployee(Integer empId) {

		LoggerSingelton.getLottger()
				.info(EmployeeStartMenuBuilder.getLoggedInEmployee().getUserName() + " fired employee id = " + empId);

		return EmployeeDao.delete(empId);
	}

	public static Integer insertAcceptedOffer(Integer offId) {

		Offer off = OfferDao.getOfferById(offId);
		BigDecimal numWeeklyPayDeci = new BigDecimal(off.getNumOfWeeklyPayments());

		BigDecimal weeklyPayment = off.getPrice().divide(numWeeklyPayDeci, 2, RoundingMode.HALF_UP);

		Item ite = ItemDao.getById(off.getIteId());
		ite.setOwnerId(off.getCustId());
		ite.setPrice(off.getPrice());
		ite.setweeklyPay(weeklyPayment);
		ite.setRemainingPayments(off.getNumOfWeeklyPayments());

		OfferDao.deleteByItemId(ite.getId());

		LoggerSingelton.getLottger()
				.info(EmployeeStartMenuBuilder.getLoggedInEmployee().getUserName() + " Accepted offer id = " + offId
						+ " item id = " + ite.getId() + " customer id = " + ite.getOwnerId() + " offer price = "
						+ off.getPrice());

		return ItemDao.updateOwner(ite);

	}

	public static Integer removeOffer(Integer offId) {

		LoggerSingelton.getLottger()
				.info(EmployeeStartMenuBuilder.getLoggedInEmployee().getUserName() + " Rejected offer id = " + offId);
		return OfferDao.deleteByOfferId(offId);
	}

	public static Integer removeItem(Integer itemId) {

		LoggerSingelton.getLottger()
				.info(EmployeeStartMenuBuilder.getLoggedInEmployee().getUserName() + " deleted item id = " + itemId);
		return ItemDao.deleteById(itemId);

	}

	public static Integer updateItem(Item ite) {

		LoggerSingelton.getLottger().info(
				EmployeeStartMenuBuilder.getLoggedInEmployee().getUserName() + " edited item id = " + ite.getId());

		return ItemDao.update(ite);

	}

	public static Integer addItem(Item ite) {

		LoggerSingelton.getLottger().info(EmployeeStartMenuBuilder.getLoggedInEmployee().getUserName()
				+ " added item name = " + ite.getItemName());
		return ItemDao.add(ite);
	}

}
