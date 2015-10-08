package com.team.one.command

import com.team.one.domain.EndorsementCommand
import com.team.one.domain.FinancialInfoCommand
import com.team.one.domain.ReferencesCommand
import com.team.one.domain.SureCommand
import com.team.one.domain.TransactionalProfileCommand
import com.team.one.domain.WorkInfoCommand
import com.team.one.domain.enums.*
import com.team.one.command.*

class CreditCommand{

  ClientCommand clientCommand
  AddressCommand addressCommand
  WorkInfoCommand workInfoCommand
  EndorsementCommand endorsementCommand
  ReferencesCommand referencesCommand
  FinancialInfoCommand financialInfoCommand
  SureCommand sureCommand
  TransactionalProfileCommand transactionalProfileCommand

}
