package com.Main.controller;

import com.Main.entity.JournalEntry;
import com.Main.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {


    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry)
    {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntrybyID(@PathVariable ObjectId myId)
    {
      return journalEntryService.findById(myId).orElse(null);
    }
    @DeleteMapping ("id/{myId}")
    public boolean deleteJournalEntrybyID(@PathVariable ObjectId myId)
    {
           journalEntryService.deleteById(myId);
          return  true;
    }
    @PutMapping ("id/{myId}")
    public JournalEntry updateJournalEntrybyID(@PathVariable ObjectId myId,@RequestBody JournalEntry newEntry)
    {
        JournalEntry old=journalEntryService.findById(myId).orElse(null);
       if (old!=null)
       {
         old.setTitle(newEntry.getTitle()!=null&&!newEntry.getTitle().equals("")?newEntry.getTitle():old.getTitle());
         old.setContent(newEntry.getContent() !=null && !newEntry.equals("")?newEntry.getContent():old.getContent());
       }
       journalEntryService.saveEntry(old);
       return old;
    }
}
