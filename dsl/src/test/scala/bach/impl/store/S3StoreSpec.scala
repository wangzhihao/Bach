package bach.impl.store

import org.scalatest._
import bach.util._

class S3StoreSpec extends FlatSpec with Matchers {
  "Move data from s3 to ddb" should "work" in {
    val s3Store = S3Store[Json]("s3://foobucket/fooprefix", mapper)
    val ddbStore = DDBStore[Json]("arn:aws:dynamodb:us-west-2:618458174671:table/AbpSuppressionSnsMessages-prod-JPAmazon", mapper)
    s3Store.moveTo(ddbStore)
  }

  "A ddb continously listen on another ddb" should "work" in {
    val ddb1 = DDBStore[Json]("arn:aws:dynamodb:us-west-2:618458174671:table/AbpSuppressionSnsMessages-prod-JPAmazon")
    val ddb2 = DDBStore[Json]("arn:aws:dynamodb:us-west-2:618458174671:table/AbpSuppressionSnsMessages-prod-JPAmazon")
    ddb2.listen(ddb1, {fromBeginning: true})
  }

  "Filter on the s3 data and show results" should "work" in {
    val s3Store = S3Store[Json]("s3://foobucket/fooprefix")
    s3Store.toStream().filter(a => b).tail()
  }

  "ddb publish result to sns" should "work" in {
    val ddbStore = DDBStore[Json]("arn:aws:dynamodb:us-west-2:618458174671:table/AbpSuppressionSnsMessages-prod-JPAmazon")
    val sns = ddbStore.toSNS()
  }
}
