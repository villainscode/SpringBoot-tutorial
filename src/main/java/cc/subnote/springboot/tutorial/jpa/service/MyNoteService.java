package cc.subnote.springboot.tutorial.jpa.service;

import cc.subnote.springboot.tutorial.jpa.dto.MyNoteDTO;
import cc.subnote.springboot.tutorial.jpa.dto.TagDTO;
import cc.subnote.springboot.tutorial.jpa.entity.MyNoteEntity;
import cc.subnote.springboot.tutorial.jpa.entity.TagEntity;
import cc.subnote.springboot.tutorial.jpa.exception.MyNoteNotFoundException;
import cc.subnote.springboot.tutorial.jpa.repository.MyNoteRepository;
import cc.subnote.springboot.tutorial.jpa.repository.TagRepository;
import cc.subnote.springboot.tutorial.jpa.request.MyNoteRequest;
import cc.subnote.springboot.tutorial.jpa.request.TagRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;

import java.util.*;

@Slf4j
@Service
public class MyNoteService {

    private final MyNoteRepository myNoteRepository;
    private final TagRepository tagRepository;
    private final ModelMapper modelMapper;


    public MyNoteService(MyNoteRepository myNoteRepository, TagRepository tagRepository, ModelMapper modelMapper) {
        this.myNoteRepository = myNoteRepository;
        this.tagRepository = tagRepository;
        this.modelMapper = modelMapper;
    }

    public List<MyNoteEntity> findAll() {
        return myNoteRepository.findAll();
    }

    public MyNoteRequest save(MyNoteRequest noteRequest) {
        MyNoteEntity entity = toEntity(noteRequest);
        List<TagEntity> tagList = new ArrayList<>();
        if (!noteRequest.getTag().isEmpty()) {

            for (TagRequest t : noteRequest.getTag()) {
                TagEntity tag = new TagEntity();
                tag.setMyTagName(t.getTagName());
                tag.setMyNote(entity);
                tagList.add(tag);
            }
            entity.setTag(tagList);
        }
        ModelMapper modelMapper = new ModelMapper();
        MyNoteEntity save = myNoteRepository.save(entity);
        return modelMapper.map(save, MyNoteRequest.class);
    }

    private MyNoteEntity toEntity(MyNoteRequest request) {
        MyNoteEntity entity = new MyNoteEntity();
        entity.setTitle(request.getTitle());
        entity.setContent(request.getContent());
        entity.setCreatedAt(new Date());
        entity.setDone(request.isDone());

        return entity;
    }

    public MyNoteDTO findById(Long id) {
        MyNoteEntity entity = myNoteRepository.findById(id).orElseThrow(() -> new MyNoteNotFoundException(id));
        MyNoteDTO myNoteDTO;
        TagDTO tagDTO;
        List<TagDTO> tagList = new ArrayList<>();

        myNoteDTO = new MyNoteDTO(entity.getId(), entity.getTitle(), entity.getContent(), entity.isDone(), entity.getCreatedAt());

        List<TagEntity> tags = entity.getTag();

        if (tags != null) {
            for (TagEntity tag : tags) {
                tagDTO = new TagDTO(tag.getId(), tag.getMyTagName(), tag.isDeleted());
                tagList.add(tagDTO);
            }
            myNoteDTO.setTags(tagList);
        }
        return myNoteDTO;
    }

    public void update(Long id, MyNoteRequest myNoteRequest) {
        MyNoteEntity entity = myNoteRepository.findById(id).orElseThrow(() -> new MyNoteNotFoundException(id));
        entity.setTitle(myNoteRequest.getTitle());
        entity.setContent(myNoteRequest.getContent());
        entity.setDone(myNoteRequest.isDone());

        for (TagRequest tagRequest : myNoteRequest.getTag()) {
            Optional<TagEntity> tagOptional = entity.getTag().stream()
                    .filter(t -> t.getId().equals(tagRequest.getId()))
                    .findFirst();

            if (tagOptional.isPresent()) {
                TagEntity tag = tagOptional.get();
                tag.setMyTagName(tagRequest.getTagName());
                tag.setDeleted(tagRequest.isDeleted());
            } else {
                TagEntity tag = new TagEntity();
                tag.setMyTagName(tagRequest.getTagName());
                tag.setMyNote(entity);
                entity.getTag().add(tag);
            }
        }
        myNoteRepository.save(entity);
    }

    /**
     private List<TagEntity> addTag(MyNoteEntity entity, List<String> tags) {
     List<TagEntity> entities = new ArrayList<>();
     if (!tags.isEmpty()) {
     for (String tag : tags) {
     TagEntity tagEntity= new TagEntity();
     tagEntity.setMyNote(entity);
     tagEntity.setMyTagName(tag);
     tagEntity.setDeleted(false);
     }
     }
     return null;
     }
     */

    public void delete(Long id) {
        myNoteRepository.deleteById(id);
    }

    public List<TagEntity> findMyTagAll() {
        return tagRepository.findAll();
    }

    public MyNoteDTO findByTag() {
        Optional<TagEntity> tag = tagRepository.findById(1L);
        MyNoteDTO myNote = null;
        if (tag.isPresent()) {
            MyNoteEntity note = tag.get().getMyNote();
            myNote = new MyNoteDTO(note.getId(), note.getTitle(), note.getContent(), note.isDone(), note.getCreatedAt());
        }
        return myNote;
    }
}