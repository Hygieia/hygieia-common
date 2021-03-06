package com.capitalone.dashboard.repository;

import com.capitalone.dashboard.model.CollectorItem;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Base {@link CollectorItem} repository that provides methods useful for any {@link CollectorItem}
 * implementation.
 *
 * @param <T> Class that extends {@link CollectorItem}
 */
public interface BaseCollectorItemRepository<T extends CollectorItem> extends QueryRepository<T> {
    Logger LOGGER = LoggerFactory.getLogger(BaseCollectorItemRepository.class);

    /**
     * Finds all {@link CollectorItem}s that are enabled.
     *
     * @return list of {@link CollectorItem}s
     */
    List<T> findByEnabledIsTrue();

    /**
     * Finds all {@link CollectorItem}s that match the provided id's.
     *
     * @param ids {@link Collection} of ids
     * @return list of {@link CollectorItem}s
     */
    List<T> findByCollectorIdIn(Collection<ObjectId> ids);

    /**
     * Finds all {@link CollectorItem}s that match the provided id's.
     *
     * @param ids {@link Collection} of ids
     * @param pageable
     * @return Page of {@link CollectorItem}s
     */
    Page<T> findByCollectorIdIn(Collection<ObjectId> ids, Pageable pageable);
    
    /**
     * Finds paged results of {@link CollectorItem}s that match the provided id's.
     *
     * @param ids {@link Collection} of ids
     * @param description {@link String}
     * @param pageable {@link org.springframework.data.domain.Pageable} object to determine which page to return
     * @return page of {@link CollectorItem}s
     */
    Page<T> findByCollectorIdInAndDescriptionContainingIgnoreCase(Collection<ObjectId> ids, String description, Pageable pageable);

    /**
     * Finds the {@link CollectorItem} for a given collector and options. This should represent a unique
     * instance of a {@link CollectorItem} for a given {@link com.capitalone.dashboard.model.Collector}.
     *
     * @param collectorId {@link com.capitalone.dashboard.model.Collector} id
     * @param options     options
     * @return a {@link CollectorItem}
     */

    T findByCollectorAndOptions(ObjectId collectorId, Map<String, Object> options);

    List<T> findByCollectorIdAndNiceName(ObjectId collectorId, String niceName);

    Page<T> findByCollectorIdInAndDescriptionContainingAndNiceNameContainingAllIgnoreCase(Collection<ObjectId> ids, String jobName, String niceName, Pageable pageable);

    @Override
    default T findOne(ObjectId id) {
        return findOne("id eq '" + id + '\'');
    }
}
