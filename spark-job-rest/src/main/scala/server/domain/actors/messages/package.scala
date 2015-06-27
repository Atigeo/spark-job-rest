package server.domain.actors

import persistence.slickWrapper.Driver.api._

/**
 * Namespace for common actor messages.
 * Actor specific messages should be defined in it's container object.
 * If at least 2 actors receive one message it SHOULD be moved here.
 */
package object messages {
  /**
   * Sent when actor is not initialized but requested for something
   */
  case object Uninitialized

  /**
   * This message should be sent to actor to initialize it
   */
  case object Init

  /**
   * Requests database info from [[DatabaseServerActor]] and [[DatabaseConnectionActor]]
   */
  case object GetDatabaseInfo

  /**
   * Passes database info obtained by [[DatabaseServerActor]] and [[DatabaseConnectionActor]]
   * @param dbName database name
   * @param status server status
   * @param url server url
   * @param connectionString connection string
   */
  case class DatabaseInfo(dbName: String, status: String, url: String, connectionString: String)

  /**
   * Requests database connection from [[DatabaseServerActor]] and [[DatabaseConnectionActor]]
   */
  case object GetDataBaseConnection

  /**
   * Passes database connection obtained by [[DatabaseServerActor]] and [[DatabaseConnectionActor]]
   * @param db database connection
   */
  case class DatabaseConnection(db: Database)
}