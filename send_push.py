# -*- coding: utf-8 -*-
import json
import requests


def main(server_key, token, message_body):
    headers = {
        'Authorization': 'key= ' + server_key,
        'Content-Type': 'application/json',
    }

    data = {
        'to': token,
        'data': {
            'message_body': message_body,
        },
    }

    response = requests.post('https://fcm.googleapis.com/fcm/send', headers=headers, data=json.dumps(data))
    print(response)


if __name__ == '__main__':
    server_key = '----'  # Firebase Project Settings > CLOUD MESSAGING
    token = '----'       # User's refreshed Token
    message_body = ''    # 푸쉬 메세지
    main(server_key, token, message_body)
