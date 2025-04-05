#!/bin/bash

session="jlox"

tmux new-session -d -s $session

tmux rename-window -t 1 'nvim'
tmux send-keys -t 'nvim' 'cd src/com/craftinginterpreters/lox' C-m 'nvim .' C-m

tmux new-window -t $session:2 -n 'compiler'

tmux attach-session -t $session:1
