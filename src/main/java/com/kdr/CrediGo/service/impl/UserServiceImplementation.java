package com.kdr.CrediGo.service.impl;

import com.kdr.CrediGo.dto.*;
import com.kdr.CrediGo.entity.User;
import com.kdr.CrediGo.repository.UserRepository;
import com.kdr.CrediGo.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Override
    public BankResponse createAccount(UserRequest userRequest) {
        /**
         * Creating an account - saving a new user into the database
         * check if user already has an account
         */

        if (userRepository.existsByEmail(userRequest.getEmail())) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .build();
        }

        User newUser = User.builder()
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .regionOfOrigin(userRequest.getRegionOfOrigin())
                .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
                .status("ACTIVE")
                .build();

        User savedUser = userRepository.save(newUser);

        // Send email Alert
        EmailDetails emailDetails = EmailDetails.builder()
                .recipient(savedUser.getEmail())
                .subject("<b>Welcome to CrediGo!<b>")
                .messageBody(
                        "<html><body>" +
                                "<p>Your account is live! Your new account comes with access to <b>CrediGo's products and services.</b></p>" +
                                "<p><b>Account Details:</b></p>" +
                                "<p><b>Account Name:</b> <i>" + savedUser.getFirstName() + " " + savedUser.getLastName() + "</i> <br>" +
                                "<b>Account Number:</b> <i>" + savedUser.getAccountNumber() + "</i></p>" +
                                "</body></html>"
                )
                .build();
        emailService.sendEmailAlert(emailDetails);

        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS_CODE)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(savedUser.getAccountBalance())
                        .accountNumber(savedUser.getAccountNumber())
                        .accountName(savedUser.getFirstName() + " " + savedUser.getLastName())
                        .build())
                .build();

    }

    @Override
    public BankResponse balanceInquiry(InquiryRequest inquiryRequest) {
        return BankResponse.builder()

                .build();
    }

    @Override
    public String nameInquiry(InquiryRequest inquiryRequest) {
        return "";
    }
}
