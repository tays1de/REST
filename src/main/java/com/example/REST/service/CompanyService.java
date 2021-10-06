package com.example.REST.service;

import com.example.REST.entity.Company;
import com.example.REST.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public void save(Company company) {
        companyRepository.save(company);
    }


/*    public Page<Company> findPaginate(int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return this.companyRepository.findAll(pageable);
    }
*/
    public List<Company> listAll() {
        List<Company> companyList = (List<Company>) companyRepository.findAll();

        companyList.removeIf(Company::isDelete);

        return companyList;
    }

    public void softDelete(Long id){
        Company company = companyRepository.findById(id).get();
        company.setDelete(true);
        companyRepository.save(company);
    }

    public List<Company> listOfAdverister(Long adverister_id) {
        List<Company> companyList = (List<Company>) companyRepository.findAll();
        List<Company> result = new ArrayList<>();
        for (Company company :
                companyList) {
            if (company.getAdvertisers().getId() == adverister_id) {
                result.add(company);
            }
        }
        return result;
    }

    public Company get(Long id) {
        return companyRepository.findById(id).get();
    }

    public void delete(Long id) {
        companyRepository.deleteById(id);
    }


}
