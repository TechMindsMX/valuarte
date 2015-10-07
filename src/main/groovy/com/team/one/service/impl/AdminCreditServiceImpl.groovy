package com.team.one.service.impl

import com.team.one.command.*
import com.team.one.domain.*
import com.team.one.repository.*
import com.team.one.service.AdminCreditService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service


@Service
class AdminCreditServiceImpl implements AdminCreditService {

    @Autowired
    AddressRepository addressR
    @Autowired
    ClientRepository clientR
    @Autowired
    EndorsementRepository endorsementR
    @Autowired
    FinancialInfoRepository financialR
    @Autowired
    ReferencesRepository referenceR
    @Autowired
    SureRepository sureR
    @Autowired
    TransactionalProfileRepository transactionalR
    @Autowired
    WorkInfoRepository workR

    @Override
    Client create(List domainList,String userCreate) {
      def address = addressR.save(domainList.address)
      def endorsement = endorsementR.save(domainList.endorsement)
      def financial = financialR.save(domainList.financial)
      def reference = referenceR.save(domainList.refrence)
      def sure = sureR.save(domainList.sure)
      def transactional = transactionalR.save(domainList.transactional)
      def workInfo = workR.save(domainList.work)
      def client = domainList.client
      client.addressId = address.id
      client.endorsementId = endorsement.id
      client.financialInfoId = financial.id
      client.referencesId = reference.id
      client.sureId = sure.id
      client.transactionalProfileId = transactional.id
      client.workInfoId = workInfo.id
      client.userCreate = userCreate
      clientR.save(client)

    }

}
