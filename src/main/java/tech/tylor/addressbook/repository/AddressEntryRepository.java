package tech.tylor.addressbook.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tech.tylor.addressbook.model.AddressEntry;

@Repository
public interface AddressEntryRepository extends CrudRepository<AddressEntry, Long> {


}
