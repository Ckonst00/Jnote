### Jnote - what a brilliant name right? because Java...

A simple note application using only Java.

---
Technologies:
- Java 21
- JavaFX

---
Basic functionality:
- Read, add, delete notes

Advanced functionalities
- Different sorting methods

Adding and deleting notes works. Modifying does not yet.

<img width="847" height="627" alt="kuva" src="https://github.com/user-attachments/assets/9e40ea04-4168-4e1b-bc47-1f79ccd5a66b" />

By pressing the "+", a form appears for new note.
<img width="846" height="630" alt="kuva" src="https://github.com/user-attachments/assets/7df42cab-f7be-40d6-ac0c-5aa94b1e80cf" />


---
Storage:

Notes are stored in a `notes.json` file in the following format:

```json
[
  {
    "title": "Stayin' Alive by Bee Gees",
    "content": "Listening this currently on spotify.",
    "date": "20.4.2026",
    "id" : "1fd5f530-e9eb-48ab-8565-e0b0ba838499"
  }
]
```
