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
    @Autowired
    OwnerIdentificationRepository ownerR
    @Autowired
    PLDInterviewRepository pldR

    Client create(Map domainList,String userCreate) {
      def address = addressR.save(domainList.address)
      def endorsement = endorsementR.save(domainList.endorsement)
      def financial = financialR.save(domainList.financial)
      def reference = referenceR.save(domainList.reference)
      def transactional = transactionalR.save(domainList.transactional)
      def workInfo = workR.save(domainList.work)
      def ownerIdentification = ownerR.save(domainList.owner ?: new OwnerIdentification())
      def pldInterview = pldR.save(domainList.pld)
      def client = domainList.client
      client.address = address
      client.endorsement = endorsement
      client.financialInfo = financial
      client.references = reference
      client.transactionalProfile = transactional
      client.workInfo = workInfo
      client.ownerIdentification = ownerIdentification
      client.pldInterview = pldInterview
      client.userCreate = userCreate
      clientR.save(client)
      client
    }

    private def createClientRelationshipWithUser(Client client, User user) {
      UserClient userClient = new UserClient(user: user,client: client)
      userClientRepository.save(userClient)
    }

}
