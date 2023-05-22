import uuid
from datetime import datetime
import os.path
import json
import argparse

class Note:
    def __init__(self, title, body):
        self.id = str(uuid.uuid4())
        self.title = title
        self.body = body
        self.created_at = datetime.now()
        self.updated_at = self.created_at

    def update(self, title=None, body=None):
        self.title = title or self.title
        self.body = body or self.body
        self.updated_at = datetime.now()

    def __str__(self):
        return f'{self.title} ({self.created_at})'
        
    def json(self):
        return {
            'id': self.id,
            'title': self.title,
            'body': self.body,
            'created_at': self.created_at.timestamp(),
            'updated_at': self.updated_at.timestamp()
        }

    @classmethod
    def from_json(cls, json_data):
        note = cls(json_data['title'], json_data['body'])
        note.id = json_data['id']
        note.created_at = datetime.fromtimestamp(json_data['created_at'])
        note.updated_at = datetime.fromtimestamp(json_data['updated_at'])
        return note
    
class Notebook:
    def __init__(self, file_path='notes.json'):
        self.file_path = file_path
        if not os.path.isfile(file_path):
            with open(file_path, 'w') as f:
                f.write('[]')

    def add(self, note):
        notes = self.get_all_notes()
        notes.append(note.json())
        with open(self.file_path, 'w') as f:
            f.write(json.dumps(notes))

    def get_all_notes(self):
        with open(self.file_path, 'r') as f:
            notes = json.loads(f.read())
        return [Note.from_json(note_json) for note_json in notes]

    def get_note_by_id(self, note_id):
        notes = self.get_all_notes()
        for note in notes:
            if note.id == note_id:
                return note
        return None

    def update(self, note_id, new_title=None, new_body=None):
        notes = self.get_all_notes()
        for note in notes:
            if note.id == note_id:
                if new_title is not None:
                    note.title = new_title
                if new_body is not None:
                    note.body = new_body
                note.update(new_title, new_body)
        self.save_notes(notes)

    def delete(self, note_id):
        notes = self.get_all_notes()
        notes = [note for note in notes if note.id != note_id]
        self.save_notes(notes)

    def save_notes(self, notes):
        with open(self.file_path, 'w') as f:
            f.write(json.dumps([note.json() for note in notes]))

    def add_note_from_input(self):
        title = input('Введите заголовок заметки: ')
        body = input('Введите тело заметки: ')
        note = Note(title, body)
        self.add(note)
        print('Заметка успешно сохранена')

    def list_notes(self):
        notes = self.get_all_notes()
        for note in notes:
            print(f'{note}\n{note.body}\n')

    def list_notes_by_date(self, date_str):
        date = datetime.strptime(date_str, '%Y-%m-%d')
        notes = self.get_all_notes()
        for note in notes:
            if note.created_at.date() == date.date() or note.updated_at.date() == date.date():
                print(f'{note}\n{note.body}\n')

    def update_note_from_input(self):
        note_id = input('Введите идентификатор заметки: ')
        note = self.get_note_by_id(note_id)
        if note is None:
            print('Заметка не найдена')
            return
        title = input(f'Введите новый заголовок заметки ({note.title}): ') or note.title
        body = input(f'Введите новое тело заметки ({note.body}): ') or note.body
        self.update(note_id, new_title=title, new_body=body)
        print('Заметка успешно обновлена')

    def delete_note_from_input(self):
        note_id = input('Введите идентификатор заметки: ')
        note = self.get_note_by_id(note_id)
        if note is None:
            print('Заметка не найдена')
            return
        self.delete(note_id)
        print('Заметка успешно удалена')

def main():
    parser = argparse.ArgumentParser(description='Notebook application')
    parser.add_argument('-l', '--list', action='store_true', help='List all notes')
    parser.add_argument('-a', '--add', action='store_true', help='Add a new note')
    parser.add_argument('-u', '--update', action='store_true', help='Update an existing note')
    parser.add_argument('-d', '--delete', action='store_true', help='Delete an existing note')
    parser.add_argument('--date', help='Filter notes by date (format: YYYY-MM-DD)')
    args = parser.parse_args()

    notebook = Notebook()

    if args.list:
        if args.date:
            notebook.list_notes_by_date(args.date)
        else:
            notebook.list_notes()
    elif args.add:
        notebook.add_note_from_input()
    elif args.update:
        notebook.update_note_from_input()
    elif args.delete:
        notebook.delete_note_from_input()

main()