package com.pigtail.forumService.service;

import com.pigtail.forumService.dao.TagDao;
import com.pigtail.forumService.dto.TagResponse;
import com.pigtail.forumService.model.Forum;
import com.pigtail.forumService.model.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagDao tagDao;
    public List<Tag> save(List<String> tags) {
        return tags.stream().map(this::save).toList();
    }
    public Tag save(String name){
        if(!tagDao.existsById(name)){
            Tag tag =  Tag.builder()
                    .name(name)
                    .build();
            tagDao.save(tag);
            return tag;
        }
        else{
            return tagDao.findById(name).get();
        }
    }
    public List<TagResponse> getAll(){
//        return tagDao.findAll().stream().map(tag -> {
//            return tag.getName()+
//                    "forumId"+tag.getForums().get(0).getId();
//        }).toList();
        return tagDao.findAll().stream().map(tag -> {
            return TagResponse.builder()
                    .forums(tag.getForums().stream().map(Forum::getId).toList())
                    .name(tag.getName())
                    .build();
        }).toList();
    }
}
