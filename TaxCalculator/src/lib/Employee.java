package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;

public class Employee extends PersonalInfo{

	private int employeeId;
	
	private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;
		
	public Employee(int employeeId, PersonalInfo info, Job job) {
		this.employeeId = employeeId;
		this.setFirstName(info.getFirstName());
		this.setLastName(info.getLastName());
		this.setIdNumber(info.getIdNumber());
		this.setAddress(info.getAddress());
                this.setJoinDate(info.getJoinDate());
		this.setIsForeigner(info.getIsForeigner());
		this.setGender(info.getGender());
                this.setChildNames(info.getChildNames());
		this.setChildIdNumbers(info.getChildIdNumbers());
	}
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	public void setMonthlySalary(Job job) {	
            int grade = job.getGrade();
		if (grade == 1) {
			monthlySalary = 3000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		}else if (grade == 2) {
			monthlySalary = 5000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		}else if (grade == 3) {
			monthlySalary = 7000000;
			if (isForeigner) {
				monthlySalary = (int) (3000000 * 1.5);
			}
		}
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	
	public int getAnnualIncomeTax() {
		
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == joinDate.getYear()) {
			monthWorkingInYear = date.getMonthValue() - joinDate.getMonthValue();
		}else {
			monthWorkingInYear = 12;
		}
		
                boolean ismarried = spouseIdNumber != 0;
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, ismarried, childIdNumbers.size());
	}
}