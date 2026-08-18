<p align="center"><img src="https://raw.githubusercontent.com/DrakesCraft-Labs/Cringle-Bosses/main/banner.svg" alt="Cringle-Bosses" width="100%"></p>

# Cringle-Bosses

Jefes invocados por ritual, adaptado al ecosistema Slimefun de **DrakesCraft** (Paper/Purpur 1.21.11, Java 21).

## Qué añade

Diecisiete objetos y un Altar de Invocación: se construye con pedestales y campanas, y el ritual hace aparecer al jefe. No trae comandos; todo pasa por el altar.

## Ojo con esto

Convive con DrakesBosses sin chocar: identificadores propios con prefijo `CRINGLE_`, ningún comando compartido, y sus jefes usan un tipo de entidad que DrakesBosses no toca.

## Qué cambiamos

Este repositorio **no es un fork**: es el código original integrado en el ecosistema de
DrakesCraft (Paper/Purpur 1.21.11, Java 21). Los cambios comunes a todos nuestros ports son:

**Los paquetes de Slimefun.** El core de DrakesCraft está repaquetado, así que un addon de fuera
no encuentra nada hasta que se remapean sus imports.

**La telemetría, fuera.** bStats abría una conexión a bstats.org cada pocos minutos con datos del
servidor. Se quitaron las llamadas, los imports y la dependencia — no se sustituyó por un stub
inerte, que dejaría el código en pie aparentando que hay telemetría.

**Los autoactualizadores, desarmados.** Este jar está recompilado contra nuestro Slimefun; si se
bajara el de upstream encima, dejaría de cargar. Las actualizaciones se despliegan por SFTP.

**El rastreador de fallos apunta aquí**, no al repositorio original: un fallo de esta versión
casi nunca es un fallo de allí.
