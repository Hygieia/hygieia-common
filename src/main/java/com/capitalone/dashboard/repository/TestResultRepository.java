package com.capitalone.dashboard.repository;

import com.capitalone.dashboard.model.TestResult;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Repository for {@link TestResult} data.
 */
public interface TestResultRepository extends QueryRepository<TestResult> {

    /**
     * Finds the {@link TestResult} with the given execution ID for a specific
     * {@link com.capitalone.dashboard.model.CollectorItem}.
     *
     * @param collectorItemId collector item ID
     * @param executionId execution ID
     * @return a TestSuite
     */
    TestResult findByCollectorItemIdAndExecutionId(ObjectId collectorItemId, String executionId);

    TestResult findByCollectorItemId(ObjectId collectorItemId);
    
    List<TestResult> findByUrlAndTimestampGreaterThanEqualAndTimestampLessThanEqual(String jobUrl,long beginDt,long endDt);
    List<TestResult> findByCollectorItemIdAndTimestampIsBetweenOrderByTimestampDesc(ObjectId collectorItemId, long beginDate, long endDate);

}
