package com.springbootcrudfullstackwithmaven.rooms.service;

import com.springbootcrudfullstackwithmaven.rooms.model.Owner;
import com.springbootcrudfullstackwithmaven.rooms.repository.OwnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OwnerService {

    @Autowired
    private OwnRepository ownerRepository;

    public List<Owner> getAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        if(CollectionUtils.isEmpty(owners)) {
            throw new IllegalArgumentException("oweners not found");
        }
        return owners;
    }

    public Owner getOwnerById(int ownerId) {
        return tryFetchById(ownerId)
                .orElseThrow(() -> new IllegalArgumentException("Owner Not found"));
    }

    public int updateOwnerDetails(Owner owner) {
        //System.out.println("Room details::: "+room.getRent()+" id: "+room.getRoomId()+" description: "+room.getDescription());
        return ownerRepository.updateOwner(owner.getOwnerId(), owner.getOwnerName(), owner.getOwnerContact(), owner.getOwnerMail(), owner.getLocation(), owner.getNoOfVacancy());
    }

    @Transactional
    public Owner[] addOwners(Owner[] owners) {
        Owner[] ownersAdded = new Owner[owners.length];
        int ownerCount = 0;
        for(Owner owner: owners){
            ownersAdded[ownerCount] = ownerRepository.save(owner);
            ownerCount ++;
        }
        return ownersAdded;
    }

    public String deleteById(int ownerId) {
        ownerRepository.deleteOwner(ownerId);
        return ownerId+"has been deleted";
    }

    public Optional<Owner> tryFetchById(int ownerId) {
        return Optional.ofNullable(ownerRepository.getOne(ownerId));
    }

}
