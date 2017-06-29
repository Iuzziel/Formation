Option Explicit
Randomize

'Déclaration des variables'
Dim tabTest(3), tabRep(3), tabPosOk(3), tabCoulOk(3), chiffrePossible, choixTest, tentative, essaisPasses, nbTentatives, nbPosOk, nbCoulOk, statutMsg
'Initialisation des variables'
statutMsg = ""
essaisPasses = "" 'Variable contenant tout les essais déjà effectués par l'utilisateur
choixTest = "" 'Variable contenant la série à trouver
tentative = "0000" 'Variable contenant la tentative en cours de l'utilisateur
nbTentatives = 0
chiffrePossible = "12345678" 'Variable pour le contrôle de saisie'

Call main
'''''''''''''''''''''''''''''''''''''''''''''''''
'		Déclaration de la Sub Principale		'
	Sub main
		Call storeTest 'Remplissage du tableau par la valeure aléatoire décomposée (un chiffre par case)'
		Do 
			Call resetVerif 'Reset des tableaux booleen'
			Call verifCoul 'Remplissage du tableau verifCoul booleen de vérification'
			Call verifPos 'Remplissage du tableau verifPos booleen de vérification'
			Call statutPartie 'Création du texte statutPartie à inclure dans la inputbox'
			Call saisieUser 'Inputbox de jeu, avec affichage des infos'
		Loop Until(endGame(tabPosOk, tabCoulOk) Or nbTentatives = 8)

		MsgBox("Fin du jeu")
	'Décomposition des solution de fin de jeu, et affichage des messages en conséquences'
		If(nbTentatives = 8)Then
			MsgBox("Vous avez épuisé vos tentatives.")
		ElseIf(endGame(tabPosOk, tabCoulOk))Then
			MsgBox("Vous avez trouvé la bonne réponse : " & choixTest)
		Else
			MsgBox("Terminé sur erreur")
		End If
	End Sub

'''''''''''''''''''''''''''''''''''''''''''''''''
'		Déclaration de la Sub storeTest			'
	'Remplissage du tableau par la valeure aléatoire décomposée (un chiffre par case)'
	Sub storeTest
		Dim i, temp
		For i = 0 to 3
			temp = temp & CStr(Int(Rnd() * 8) + 1) 'Ligne à changer par un inputbox, si on veut qu'un utilisateur entre la valeur à chercher
		Next
		choixTest = temp
		For i = 1 to 4
			tabTest(i-1) = Mid(choixTest, i, 1)
		Next
	End Sub

'''''''''''''''''''''''''''''''''''''''''''''''''
'		Déclaration de la Sub verifPos			'
	'Remplissage du tableau verifPos booleen de vérification'
	Sub verifPos
		Dim i
		nbPosOk = 0
		For i = 0 to 3
			If(tabRep(i) = tabTest(i))Then
				tabPosOk(i) = True
				nbPosOk = nbPosOk + 1
			End If
		Next
	End Sub

'''''''''''''''''''''''''''''''''''''''''''''''''
'		Déclaration de la Sub verifCoul			'
	'Remplissage du tableau verifCoul booleen de vérification'
	Sub verifCoul
		Dim i
		nbCoulOk = 0
		For i = 0 to 3
			If(InStr(choixTest, Mid(tentative, (i+1), 1)) <> 0)Then
				tabCoulOk(i) = True
			End If
		Next		
		For i = 0 to 3
			If(tabCoulOk(i) = True)Then
				nbCoulOk = nbCoulOk + 1
			End If
		Next
	End Sub

'''''''''''''''''''''''''''''''''''''''''''''''''
'		Déclaration de la Sub saisieUser		'
	'Inputbox de jeu pour l'utilisateur, avec affichage des infos'
	Sub saisieUser
		Dim i
		tentative = InputBox(statutMsg & "Quel est votre essai ?")
		If(verifSaisieOk(essaisPasses, tentative, chiffrePossible) = True)Then
			essaisPasses = essaisPasses & vbCrLf & tentative
			nbTentatives = nbTentatives + 1
			For i = 0 to 3
				tabRep(i) = Mid(tentative, (i+1), 1)
			Next
		Else
			MsgBox("Saisie déjà utilisé, ou fausse (Entrée érronée)." & vbCrLf & "Recommencez")
		End If
	End Sub

'''''''''''''''''''''''''''''''''''''''''''''''''
'		Déclaration de la Sub statutPartie		'
	'Création du texte statutPartie à inclure dans la inputbox'
	Sub statutPartie
		statutMsg = "Tentative " & nbTentatives & vbCrLf &_
		 "Historique des essais : " & essaisPasses & vbCrLf &_
		 "Nombre de valeur bonne mais mal placées : " & (nbCoulOk - nbPosOk) & vbCrLf &_
		 "Nombre de valeur bien placées : " & nbPosOk & vbCrLf '_
	'		 & "choixTest : " & choixTest & vbCrLf' 'ligne de test pour afficher la valeure recherchée'
	End Sub

'''''''''''''''''''''''''''''''''''''''''''''''''
'		Déclaration de la Sub resetVerif		'
	'Reset des tableaux booleen, pour actualiser la partie'
	Sub resetVerif
	Dim i
		For i = 0 to 3
			tabCoulOk(i) = False
			tabPosOk(i) = False
		Next
	End Sub

'''''''''''''''''''''''''''''''''''''''''''''''''
'					FONCTIONS					'
'''''''''''''''''''''''''''''''''''''''''''''''''
'		Function endGame, renvoie booleen		'
	'Vérifie si les valeurs de la réponse coïncident avec celle du tableau à trouver'
	Function endGame(tab1, tab2)
	Dim i, compteur
		compteur = 0
		For i = 0 to 3
			If(tabRep(i) = tabTest(i))Then
				compteur = compteur + 1
			End If
		Next
		If(compteur = 4)Then
			endGame = True
		End If
	End Function


'''''''''''''''''''''''''''''''''''''''''''''''''
'		Function verifSaisieOk, renvoie booleen	'
	'On vérifie que la saisie n'a pas déjà était faite, et si elle contient bien 4 caractères'
	Function verifSaisieOk(saisiePassee, tentativeX, saisiePossible)
		Dim conteur, i
		conteur = 0
		If((Len(tentativeX) = 4) and (InStr(saisiePassee, tentativeX) = 0))Then
			For i = 0 to 3
				If(InStr(saisiePossible, Mid(tentativeX, (i+1), 1)) <> 0)Then
				conteur = conteur + 1
				End If
			Next
			If(conteur = 4)Then
				verifSaisieOk = True
			End If
		Else
			verifSaisieOk = False
		End If
	End Function

'''''''''''''''''''''''''''''''''''''''''''''''''
'					TO DO 						'
'''''''''''''''''''''''''''''''''''''''''''''''''
'Finir la vérif de saisie pour n'accepter que les chiffres
'Faire les tests
'Problèmes de comptage des bons chiffres
