Aggiornare la macchina, installare Ansible e le sue librerie, ed infine avviare il demone. 
```bash
sudo yum update
sudo dnf install ansible -y
sudo dnf install @virtualization
sudo systemctl start libvirtd
sudo systemctl enable libvirtd
touch create_vm.yml
```
Per eseguire il playbook appena creato eseguire il comando qui sotto, e poi con virsh controllare se la macchina virtuale è stata creata.
```bash
ansible-playbook create_vm.yml
sudo virsh list –all
```
Comandi utili per controllare la VM
```bash
sudo virsh list (mostra VM in esecuzione/running)
sudo virsh list –-all (mostra TUTTE le VM, incluse quelle spente o inattive)
sudo virsh start my_vm (accendi una VM)
sudo virsh reboot my_vm (riavvio della VM)
sudo virsh shutdown my_vm (spegni una VM)
sudo virt-viewer my_vm (utilizza la macchina virtuale)
```
