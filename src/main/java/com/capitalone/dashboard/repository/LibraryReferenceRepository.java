package com.capitalone.dashboard.repository;

import com.capitalone.dashboard.model.LibraryPolicyReference;

/**
 * Repository for {@link LibraryPolicyReference} data.
 */
public interface LibraryReferenceRepository extends QueryRepository<LibraryPolicyReference> {

    LibraryPolicyReference findByLibraryNameAndOrgName(String name, String orgName);
}