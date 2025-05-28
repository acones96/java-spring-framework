# Git

- [Setup](#setup)
- [Git Workflow Areas](#git-workflow-areas)
  - [Typical Git Workflow](#typical-git-workflow)
  - [Commands](#commands)
    - [Getting Started](#getting-started)
    - [Working with Files](#working-with-files)
    - [Committing Changes](#committing-changes)
    - [Viewing History](#viewing-history)
    - [Branches](#branches)
    - [Undoing Changes](#undoing-changes)
    - [Advanced Commands](#advanced-commands)

It's an open-source Version Control, which is a system that helps to track and manage changes to code over time. It allows multiple people to work on the same codebase simultaneously, keeps a history of every modification, and enables developers to revert back to previous versions if needed.

## Setup

We need to configure our git credentials: username and email. We use the following commands for this:
* `git config --global user.name {"username"}`: Let us set our username.
* `git config --global user.email {"email"}`: Let us set our email.

We can verify the credentials were set correctly by using `git config --global --list`, which allow us to see the credentials we are working with.

## Git Workflow Areas

1. **Working Directory** *(or Working Tree)*  
   This is where we **edit our files**. It reflects the current state of the project.  
   Files in the working directory can be:
    - Modified
    - Untracked
    - Deleted

2. **Staging Area** *(or Index)*  
   This is where we **prepare changes** for the next commit.  
   Use `git add` to move changes from the Working Directory to the Staging Area.
   > Think of it as a **"preview"** of what will go into your next commit.

3. **Git Repository** *(or Local Repository)*  
   This is the **.git directory** where Git **permanently stores your commit history**.  
   Running `git commit` takes what's in the Staging Area and saves it here.

4. **Remote Repository**  
   This is a **shared version** of your repository hosted online (e.g., GitHub, GitLab).  
   We **push** our commits from the local repository to the remote,  
   allowing others to **pull** and collaborate.

For every commit, it will be shown in the **commit history** in Git, which is a record of all changes that have been saved in a repository over time and they represent a snapshot of the project at a specific point.

### Typical Git Workflow

```bash
# 1. Check the current status
git status

# 2. Modify files in the working directory

# 3. Stage changes
git add filename  # Or use 'git add .' for all changes

# 4. Commit staged changes to the repository
git commit -m "Your message here"

# 5. Push commits to a remote repository
git push origin main  # Push to the 'main' branch
```

## Commands

There are many commands, here are a few of them divided into different categories:

### Getting Started
| Command                                            | Description                      |
|----------------------------------------------------|----------------------------------|
| `git init`                                         | Initialize a new Git repository. |
| `git clone <url>`                                  | Clone a remote repository.       |
| `git config --global user.name "Your Name"`        | Set global Git username.         |
| `git config --global user.email "you@example.com"` | Set global Git email.            |

### Working with Files

| Command | Description                                       |
|---------|---------------------------------------------------|
| `git status` | Show the current status of the working directory. |
| `git add <file>` | Stage a specific file for commit.                 |
| `git add .` | Stage all changes in the directory.               |
| `git restore <file>` | Discard changes in the working directory.         |
| `git rm <file>`| Remove a file and stage the deletion.             |

### Committing Changes

| Command | Description                                 |
|---------|---------------------------------------------|
| `git commit -m "message"` | Commit staged changes with a message.       |
| `git commit -am "message"` | Stage and commit tracked files in one step. |

### Viewing History
| Command              | Description |
|----------------------|-------------|
| `git log`            | View full commit history. |
| `git log --oneline`  | View concise commit history. |
| `git show <commit>`  | View details of a specific commit. |
| `git diff` | Show unstaged changes. |
| `git blame <file>` | Show who last modified each line of a file. |

### Branches
| Command               | Description |
|-----------------------|-------------|
| `git branch`          | List local branches. | 
| `git branch <name>`   | Create a new branch. |
| `git checkout <name>` | Switch to an existing branch. |
| `git checkout -b <name>` | Create and switch to a new branch. |
| `git merge <branch>` | Merge a branch into the current one. |
| `git branch -d <name>` | Delete a local branch. |

### Undoing Changes
| Command | Description |
|---------|-------------|
| `git reset <file>` | Unstage a file. |
| `git reset --hard` | Reset all changes to last commit (destructive). |
| `git revert <commit>` | Undo a commmit by creating a new one. |
| `git clean -fd` | Remove untracked files/directories (use with caution). |

### Advanced Commands
| Command | Description |
|---------|-------------|
| `git stash` | Temporarily save uncommitted changes. |
| `git stash apply` | Reapply the last stashed changes. |
| `git tag <name>` | Tag a specific commit. |
| `git rebase <branch>` | Reapply commits onto another branch. |
| `git cherry-pick <commit>` | Apply a specific commit from another branch. |
