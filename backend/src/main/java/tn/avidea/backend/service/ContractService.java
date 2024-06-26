package tn.avidea.backend.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import tn.avidea.backend.repository.ContractRepository;
import tn.avidea.backend.entity.Contract;
import jakarta.transaction.Transactional;
import tn.avidea.backend.dto.ContractDto;
import tn.avidea.backend.mappers.ContractMapper;
import java.util.List;

@Service
@Transactional
public class ContractService {
  public ContractRepository contractRepository;
  private final ContractMapper contractMapper;

  @Autowired
  public ContractService(ContractRepository contractRepository, ContractMapper contractMapper) {
    this.contractRepository = contractRepository;
    this.contractMapper = contractMapper;
  }

  public void saveContract(Contract contract) {

    contractRepository.save(contract);
    System.out.println("Contract saved successfully with id: " + contract.getContractId());
  }

  public void deleteContract(int contractId) {
    System.out.println("Deleting contract with id: " + contractId);
    contractRepository.deleteById(contractId);
  }

  public Contract getContract(int contractId) {
    return contractRepository.findByContractId(contractId);
  }

  public Contract getContractByContractNum(String contractNum) {
    return contractRepository.findByContractNum(contractNum);
  }

  public List<ContractDto> findAllContractDtos() {
    List<Contract> contracts = contractRepository.findAll();
    return contractMapper.toContractDtos(contracts);
  }
}
