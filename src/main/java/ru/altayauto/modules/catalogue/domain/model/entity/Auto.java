package ru.altayauto.modules.catalogue.domain.model.entity;

import ru.altayauto.modules.catalogue.domain.model.exception.AutoTagException;
import ru.altayauto.modules.catalogue.domain.model.exception.ImagePathException;
import ru.altayauto.modules.catalogue.domain.model.valueobject.*;

import java.util.*;
public class Auto{
    private final UUID id;
    private GovernmentRegistrationNumber governmentRegistrationNumber;
    private AutoInfo info;
    private final Set<Tag> tagList;
    private final Set<ImagePath> images;
    private Description description;

    private Auto(
        UUID id,
        GovernmentRegistrationNumber governmentRegistrationNumber,
        AutoInfo info,
        Description description,
        Set<Tag> tagList,
        Set<ImagePath> images
    ){
        this.id = id;
        this.governmentRegistrationNumber = governmentRegistrationNumber;
        this.info = info;
        this.description = description;
        this.tagList = tagList;
        this.images = images;
    }

    public Auto(
            UUID id,
            GovernmentRegistrationNumber governmentRegistrationNumber,
            AutoInfo info,
            Description description
    ){
        this(id,governmentRegistrationNumber,info,description,new HashSet<>(),new HashSet<>());
    }

    public UUID getId() {
        return id;
    }

    public GovernmentRegistrationNumber getGovernmentRegistrationNumber() {
        return governmentRegistrationNumber;
    }

    public void changeGovernmentRegistrationNumber(GovernmentRegistrationNumber governmentRegistrationNumber){
        if(!governmentRegistrationNumber.equals(this.governmentRegistrationNumber))
            this.governmentRegistrationNumber = governmentRegistrationNumber;
    }

    public AutoInfo getInfo() {
        return info;
    }

    public void editInfo(AutoInfo info){
        if(!info.equals(this.info))
            this.info = info;
    }

    public Description getDescription(){
        return this.description;
    }

    public void changeDescription(Description description){
        if(!this.description.equals(description))
            this.description = description;
    }

    public Set<Tag> getTagList() {
        return Set.copyOf(tagList);
    }

    public void addTag(Tag tag){
        if(!tagList.add(tag))
            throw new AutoTagException.AlreadyLinked();
    }

    public void removeTag(Tag tag){
        if(!tagList.remove(tag))
            throw new AutoTagException.NotLinked();
    }

    public Set<ImagePath> getImages() {
        return Set.copyOf(images);
    }

    public void addImage(ImagePath imagePath){
        if(!images.add(imagePath))
            throw new ImagePathException.AlreadyLinked();
    }

    public void removeImage(ImagePath imagePath){
        if(!images.remove(imagePath))
            throw new ImagePathException.NotLinked();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj==null || this.getClass() != obj.getClass()) return false;
        return ((Auto) obj).id.equals(this.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

