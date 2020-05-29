# TaskStop  
開発用ツール。指定したスケジューラーをコマンドで停止可能。  
[Download](https://github.com/gamesukimanIRS/TaskStop/releases/)  
## コマンド  
全てのコマンドはコンソールからのみ実行可能です。  
|  コマンド  |  説明  |
| ---- | ---- |
|  `/taskstop all`  |  サーバーで実行されている全てのタスクを停止します。  |
|  `/taskstop <int:id>`  |  \<id\>のタスクを停止します。タスクのIDについては、TaskHandler#getTaskId()などで事前に調べておいてください。  |
