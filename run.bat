@echo off
echo Compilando o sistema de catalogo de livros...

REM Cria a pasta bin se não existir
if not exist bin mkdir bin

REM Compila todos os arquivos Java do pacote
javac -d bin src\*.java

if %errorlevel% neq 0 (
    echo Erro na compilação. Verifique os arquivos.
    pause
    exit /b
)

echo Compilacao concluida com sucesso.
echo Executando o programa...

REM Executa a classe principal
java -cp bin Main

pause