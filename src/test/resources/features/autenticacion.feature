# language: es
Característica: Autenticación de Usuarios en la Plataforma
  Como usuario registrado de la plataforma
  Quiero autenticarme con mis credenciales
  Para poder acceder a mi panel principal de operaciones

  Antecedentes:
    Dado que el servicio de autenticación se encuentra operativo y disponible

  Escenario: Inicio de sesión exitoso con credenciales válidas
    Dado que el usuario con correo "usuario.activo@iplacex.cl" existe en el sistema
    Cuando ingresa su correo "usuario.activo@iplacex.cl" y su contraseña "ClaveSegura2026!"
    Entonces el sistema debe permitir el acceso
    Y debe mostrar el mensaje de bienvenida "Bienvenido al panel principal"

  Esquema del escenario: Validación de fallos de autenticación con múltiples combinaciones
    Dado que el usuario intenta identificarse en el sistema
    Cuando ingresa el correo "<correo>" y la contraseña "<password>"
    Entonces el sistema debe denegar el acceso
    Y debe mostrar el mensaje de error "<mensaje_esperado>"

    Ejemplos:
      | correo                      | password          | mensaje_esperado                      |
      | usuario.activo@iplacex.cl   | passwordInvalida  | Credenciales incorrectas verifique datos |
      | noexiste@correo.cl          | ClaveSegura2026!  | Credenciales incorrectas verifique datos |
      | correo_invalido_sin_arroba  | ClaveSegura2026!  | Formato de correo electrónico inválido   |
      |                             | ClaveSegura2026!  | El campo correo es obligatorio          |
      | usuario.activo@iplacex.cl   |                   | El campo contraseña es obligatorio      |
