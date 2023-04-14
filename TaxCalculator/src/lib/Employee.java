package lib;

import java.time.LocalDate;

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
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya 
         * grade 1: 3.000.000 per bulan,
         * grade 2: 5.000.000 per bulan,
         * grade 3: 7.000.000 per bulan,
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
        public void setMonthlySalary(Job job) {
            int grade = job.getGrade();
            int baseSalary = getBaseSalary(grade);
            monthlySalary = calculateSalary(baseSalary);
        }
        
        private int getBaseSalary(int grade) {
            switch (grade) {
                case 1:
                    return 3000000;
                case 2:
                    return 5000000;
                case 3:
                    return 7000000;
                default:
                    return 0;
            }
        }

        private int calculateSalary(int baseSalary) {
            if (isForeigner) {
                return (int) (baseSalary * 1.5);
            } else {
                return baseSalary;
            }
        }	

        public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}
	
	
	public int getAnnualIncomeTax() {
		
		int annualWorkRecap = annualRecap();
                boolean isMarried = spouseIdNumber != 0;
		return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, annualWorkRecap, annualDeductible, isMarried, childIdNumbers.size());
	}
        
        public int annualRecap(){
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == joinDate.getYear()) {
			monthWorkingInYear = date.getMonthValue() - joinDate.getMonthValue();
		}else {
			monthWorkingInYear = 12;
		}
            return monthWorkingInYear;   
        }
}