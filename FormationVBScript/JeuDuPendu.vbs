Option Explicit
Randomize
'''''''''''''''''''''''''''''''''''''''''''''''''
'					PROCEDURES					'
'''''''''''''''''''''''''''''''''''''''''''''''''
'AffichageMot, SaisieLettre, VérifLettre, Epilogue et Principal'
'''''''''''''''''''''''''''''''''''''''''''''''''
Dim Verif, Propos, Mot, Lettre, nbRepNOk, enCours, i
nbRepNOk = 0
Call main
'''''''''''''''''''''''''''''''''''''''''''''''''
'		Déclaration de la Sub Principale		'
	Sub main
'	Mise en place, et remplisage de Verif()		'
		Mot = ChoixDuMot()
		Redim Verif(Len(Mot))
		For i = 1 To Len(Mot)
			Verif(i) = False
		Next

'			Boucle principale de jeu			'
		Do
			Call AffichageMot
			Call SaisieLettre
			Call VerifLettre
		Loop Until(PartieFinie(nbRepNOk, Verif))

		Call Epilogue
	End Sub

'''''''''''''''''''''''''''''''''''''''''''''''''
'		Déclaration de la Sub AffichageMot		'
	Sub AffichageMot
		enCours = ""
		For i = 1 To UBound(Verif)
			If(Verif(i))Then
				enCours = enCours & Mid(Mot, i, 1)
			Else
				enCours = enCours & " - "
			End If
		Next
		MsgBox(enCours)
	End Sub

'''''''''''''''''''''''''''''''''''''''''''''''''
'		Déclaration de la Sub SaisieLettre		'
	Sub SaisieLettre
		Lettre = ""
		If(nbRepNOk = 0)Then
			Lettre = InputBox("Mot à deviner en " & UBound(Verif) & " lettres : " & enCours & vbCrLf & "Entrez la prochaine lettre choisie :")
		Else
			Lettre = InputBox("Mot à deviner en " & UBound(Verif) & " lettres : " & enCours & vbCrLf &_
			"Vous avez déjà essayer les lettres : " & Propos & vbCrLf &_
			"Il vous reste " & 10 - nbRepNOk & " vie(s)." & vbCrLf & "Entrez la prochaine lettre choisie :")
		End If

		If(InStr(Propos, Lettre) = 0 or InStr(Propos, Lettre) = 1)Then
			Propos = Propos & Lettre
			nbRepNOk = nbRepNOk + 1
		Else
			MsgBox("Saisie déjà utilisé, ou fausse (Entrée érronée)." & vbCrLf & "Recommencez")
		End If
	End Sub

'''''''''''''''''''''''''''''''''''''''''''''''''
'		Déclaration de la Sub VerifLettre		'
	Sub VerifLettre
			For i = 1 To Len(Mot)
				If(Mid(Mot, i, 1) = Lettre)Then
					Verif(i) = True
					nbRepNOk = nbRepNOk - 1
				End If
			Next
	End Sub

'''''''''''''''''''''''''''''''''''''''''''''''''
'		Déclaration de la Sub Epilogue			'
	Sub Epilogue
		Call AffichageMot
		If(nbRepNOk = 10)Then
			MsgBox("Vous avez épuisez vos vies.")
		Else
			MsgBox("Félicitations, le mot est bien : " & enCours & vbCrLf & "Obtenu en utilisant " & nbRepNOk & " vie(s).")
		End If
	End Sub

'''''''''''''''''''''''''''''''''''''''''''''''''
'					FONCTIONS					'
'''''''''''''''''''''''''''''''''''''''''''''''''
'ChoixDuMot, PartieFinie 						'
'''''''''''''''''''''''''''''''''''''''''''''''''
'	Function de ChoixDuMot(), renvoie une chaine'
	Function ChoixDuMot()
		Dim Mot, fso, f, random, nbLigne
		nbLigne = 0

		Set fso = CreateObject("Scripting.FileSystemObject")
		Const ForReading = 1, ForWriting = 2, ForAppending = 8
		Set f = fso.OpenTextFile("Dico.txt", ForWriting, True)
		f.WriteLine("apprendre")
		f.WriteLine("developpeur")
		f.WriteLine("informatique")
		f.WriteLine("debutant")
		f.WriteLine("comprendre")
		f.WriteLine("fonction")
		f.WriteLine("traitement")
		f.WriteLine("question")
		f.WriteLine("quelconque")
		f.WriteLine("argument")
		f.WriteLine("passage")
		f.WriteLine("contenu")
		f.Close
		
		Set f = fso.OpenTextFile("Dico.txt", ForReading)
		Do
			f.SkipLine
			nbLigne = nbLigne + 1
		Loop Until(f.AtEndOfStream)
		f.Close
		nbLigne = nbLigne - 1
		Set f = fso.OpenTextFile("Dico.txt", ForReading)
		random = CInt(Rnd() * (nbLigne))
		For i = 1 To random
			ChoixDuMot = f.ReadLine
		Next
		f.Close
	End Function

'''''''''''''''''''''''''''''''''''''''''''''''''
'	Function de PartieFinie(arg1, arg2), renvoie Booleen'
	Function PartieFinie(arg1, arg2)
		Dim cont
		cont = 0
		For i = 1 to UBound(arg2)
			If(arg2(i) = True)Then
				cont = cont + 1
			End If
		Next

		If(arg1 = 10 or cont = UBound(arg2))Then
			PartieFinie = True
		Else
			PartieFinie = False
		End If
	End Function

'''''''''''''''''''''''''''''''''''''''''''''''''
'					TO DO 						'
'''''''''''''''''''''''''''''''''''''''''''''''''
'Rajouter un fichier dictionnaire complet et y acceder directement'
