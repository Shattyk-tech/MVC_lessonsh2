package peaksoft.dao;

import org.springframework.stereotype.Component;
import peaksoft.model.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT,"Tom",24,"tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Bob",25,"bob@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT,"Mike",26,"mike@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Katy",27,"katy@index.box"));

    }
    public List<Person> index(){
        return  people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public  void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);

    }
    public void  update(int id,Person updatePerson){
        Person personToBeupdate = show(id);

        personToBeupdate.setName(updatePerson.getName());
        personToBeupdate.setAge(updatePerson.getAge());
        personToBeupdate.setEmail(updatePerson.getEmail());
        delete(id);
        people.add(personToBeupdate);

    }
    public  void  delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
