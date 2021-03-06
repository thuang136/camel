package org.apache.camel;

import java.util.List;

import org.apache.camel.spi.Synchronization;
import org.apache.camel.spi.UnitOfWork;

/**
 * Extended {@link Exchange} which contains the methods and APIs that are not primary intended for Camel end users
 * but for SPI, custom components, or more advanced used-cases with Camel.
 */
public interface ExtendedExchange extends Exchange {

    /**
     * Sets the endpoint which originated this message exchange. This method
     * should typically only be called by {@link Endpoint} implementations
     *
     * @param fromEndpoint the endpoint which is originating this message exchange
     */
    void setFromEndpoint(Endpoint fromEndpoint);

    /**
     * Sets the route id which originated this message exchange. This method
     * should typically only be called by the internal framework.
     *
     * @param fromRouteId the from route id
     */
    void setFromRouteId(String fromRouteId);

    /**
     * Sets the unit of work that this exchange belongs to; which may map to
     * zero, one or more physical transactions
     */
    void setUnitOfWork(UnitOfWork unitOfWork);

    /**
     * Adds a {@link org.apache.camel.spi.Synchronization} to be invoked as callback when
     * this exchange is completed.
     *
     * @param onCompletion  the callback to invoke on completion of this exchange
     */
    void addOnCompletion(Synchronization onCompletion);

    /**
     * Checks if the passed {@link Synchronization} instance is
     * already contained on this exchange.
     *
     * @param onCompletion  the callback instance that is being checked for
     * @return <tt>true</tt>, if callback instance is already contained on this exchange, else <tt>false</tt>
     */
    boolean containsOnCompletion(Synchronization onCompletion);

    /**
     * Handover all the on completions from this exchange to the target exchange.
     *
     * @param target the target exchange
     */
    void handoverCompletions(Exchange target);

    /**
     * Handover all the on completions from this exchange
     *
     * @return the on completions
     */
    List<Synchronization> handoverCompletions();

    /**
     * Sets the history node id (the current processor that will process the exchange)
     */
    void setHistoryNodeId(String historyNodeId);

    /**
     * Gets the history node id (the current processor that will process the exchange)
     */
    String getHistoryNodeId();

    /**
     * Sets the history node label (the current processor that will process the exchange)
     */
    void setHistoryNodeLabel(String historyNodeLabel);

    /**
     * Gets the history node label (the current processor that will process the exchange)
     */
    String getHistoryNodeLabel();

}
