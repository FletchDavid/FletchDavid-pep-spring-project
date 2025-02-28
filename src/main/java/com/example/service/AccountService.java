package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.exception.ConflictException;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account registerUser(Account user) throws ConflictException{
        if(user.getUsername().length() >= 4 && user.getPassword().length() >= 4){
            Optional<Account> account = accountRepository.findByUsername(user.getUsername());
            if(account.isEmpty()){
                return accountRepository.save(user);
            }else{
                throw new ConflictException();
            }
        }
        return null;
    }

    public Account loginUser(Account user){
        Optional<Account> target = accountRepository.findByUsername(user.getUsername());
        if(target.isEmpty()) return null;
        else if(target.get().getPassword().equals(user.getPassword())) return target.get();
        return null;
    }
}
