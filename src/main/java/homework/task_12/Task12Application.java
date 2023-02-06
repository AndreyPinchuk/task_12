package homework.task_12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class Task12Application {
	@Autowired
	private NoteService noteService;

	public static void main(String[] args) {
		SpringApplication.run(Task12Application.class, args);
	}

	@PostConstruct
	public void init(){
		System.out.println("Start");

		Note note;

		for (int i = 0; i < 8; i++) {
			note= new Note("My "+i+" title","This content");

			noteService.add(note);
		}

		try {
			note = new Note("Title","Content");
			note.setId(2L);
			noteService.update(note);

			noteService.deleteById(5);

			System.out.println(noteService.getById(8).toString());

		} catch (RuntimeException e){
			System.out.println(e.toString());
		}

		List<Note> notes = noteService.listAll();
		for (Note note1 : notes) {
			System.out.println(note1.toString());
		}

		System.out.println("Stop");
	}
}
