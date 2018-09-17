package service;

import dao.ClientDAO;
import dao.CompanyDAO;
import entity.Client;
import entity.Company;
import entity.Phone;

public class CompanyService {
    CompanyDAO companyDAO=new CompanyDAO();
    public void addingClientsToCompany(Company company,Client client){
     companyDAO.addClientsToCompany(company, client);
    }

}
