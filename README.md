# Backend
## Requirements:
**USER** (toate rolurile au acces)
* autentificare - register, login, password reset
* poate vizualiza date despre situri și artefacte
* poate cere să i se atribuie un rol
   	 
**ADMIN**
* poate crea sau edita situri - CRUD pe situri
* poate atribui un arheolog principal pentru oricare sit
* are acces la informații despre toți utilizatorii
* poate schimba rolul oricărui utilizator
* poate aproba/respinge cereri de atribuire rol
* poate aproba/respinge cereri de creare sit
   	 
**ARHEOLOG**
* poate vizualiza toate siturile și detaliile asociate
* poate vizualiza siturile pentru care a fost asignat arheolog principal
* poate vizualiza toate secțiunile dintr-un sit
* poate vizualiza orice obiect din platformă (inclusiv lab scan)
* poate introduce obiecte găsite în oricare secțiune din oricare sit dacă aparține echipei atribuite sitului
* poate edita obiecte găsite în oricare secțiune din oricare sit dacă a fost introdus de acesta
* poate cere deschiderea unui sit

* **ARHEOLOG PRINCIPAL**
  * poate crea secțiuni în situl respectiv
  * poate adăuga arheologi în echipa asociată unui sit
  * poate adăuga comentarii/notițe pentru obiecte din propriul sit
  * poate introduce/edita obiecte găsite în oricare secțiune din oricare sit deținut
  * poate marca un sit ca fiind complet săpat
  * poate marca un sit ca fiind complet analizat -> situl se va închide 
  * poate redeschide un sit pentru analiză laborator
  * poate avea o discuție (în cadrul aplicației, "chat room") despre un artefact cu arheologul care a adăugat obiectul respectiv 
  * poate avea o discuție (în cadrul aplicației, "chat room") despre un artefact cu laborantul care a analizat obiectul respectiv 
    	 
**LAB WORKER**
* poate vizualiza aceleași informații ca și arheologul
* poate realiza un lab scan pentru un obiect
* poate adăuga comentarii/notițe pentru obiecte pentru care are acces
* un singur laborant poate edita același obiect - mutex
