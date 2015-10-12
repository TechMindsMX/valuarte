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
    @Autowired
    ClientRepository clientR
    @Autowired
    UserClientRepository userClientRepository

    @Override
    Client create(List domainList,String userCreate,User user) {
      def address = addressR.save(domainList.address)
      def endorsement = endorsementR.save(domainList.endorsement)
      def financial = financialR.save(domainList.financial)
      def reference = referenceR.save(domainList.refrence)
      def sure = sureR.save(domainList.sure)
      def transactional = transactionalR.save(domainList.transactional)
      def workInfo = workR.save(domainList.work)
      def client = domainList.client
      client.address = address
      client.endorsement = endorsement
      client.financialInfo = financial
      client.references = reference
      client.sure = sure
      client.transactionalProfile = transactional
      client.workInfo = workInfo
      client.userCreate = userCreate
      clientR.save(client)
      createClientRelationshipWithUser(client,user)
      client
    }

    private def createClientRelationshipWithUser(Client client, User user) {
      UserClient userClient = new UserClient(user: user,client: client)
      userClientRepository.save(userClient)
    }

}
