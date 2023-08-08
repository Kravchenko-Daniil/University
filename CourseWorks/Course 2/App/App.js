import React, { useState } from 'react';
import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, TouchableOpacity, Alert, TextInput, KeyboardAvoidingView } from 'react-native';
import * as ImagePicker from 'expo-image-picker';
import * as MailComposer from 'expo-mail-composer';
import validator from 'validator'




export default function App() {
  const [email, setEmail] = useState("");
  const [subject, setSubject] = useState("");
  const [message, setMessage] = useState("");
  const [status, setStatus] = useState(null)

  const validateEmail = (e) => {
    if (validator.isEmail(email)) {
      Alert.alert('Email is valid')
      console.log("Email is valid")
    } else {
      Alert.alert('Email is not valid')
      console.log("Email is not valid")
    }
  }

  const showAlert = () =>
    Alert.alert(
      "Add a file",
      "Do you want to attach a file?",
      [
        {
          text: "No",
          onPress: () => {sendEmail([])},
          style: "cancel"
        },
        { text: "Yes", onPress: sendEmailWithAttachment }
      ]
    );

  const sendEmail = async(file) => {
    var options = {}
    if(file.length < 1){
      options = {
        subject: subject,
        recipients: [email],
        body: message,
      }
    }else{
      options = {
        subject: subject,
        recipients: [email],
        body: message,
        attachments: file
      }
    }
    let promise = new Promise((resolve, reject) => {
      MailComposer.composeAsync(options)
      .then((result) => {
        resolve(result)
      })
      .catch((error) => {
        reject(error)
      })
    })

    promise.then(
      result => setStatus("Status: email " + result.status),
      error => setStatus("Status: email " + error.status)
    )
  }

  const sendEmailWithAttachment = async() => {
    let result = await ImagePicker.launchImageLibraryAsync({
      mediaTypes: ImagePicker.MediaTypeOptions.All,
      allowsEditing: false,
      aspect: [4, 3],
      quality: 1,
    });

    if (!result.cancelled) {
      console.log(result.uri)
      sendEmail([result.uri]);
    }else{
      sendEmail([])
    }

  }

  return (
      <View style={styles.container}>
        <View style={styles.containerInputForm}>
          <Text style={styles.textLabel}> Name </Text>
          <TextInput style={styles.input} 
          />

          <Text style={styles.textLabel}> Email </Text>

          <TextInput style={styles.input} 
            autoCorrect={true}
            placeholder="1@email.com, 2@mail.ru"
            autoCapitalize="none" 
            autoCompleteType="email" 
            onChangeText={(email) => setEmail(email)} 
          />

        <TouchableOpacity onPress={() => validateEmail(email)} style={styles.btnCheck}>
          <Text>✔</Text>
        </TouchableOpacity>

          <Text style={styles.textLabel}> Subject </Text>
          <TextInput style={styles.input} 
            onChangeText={(subject) => setSubject(subject)} 
          />
          <Text style={styles.textLabel}> Your message </Text>
          <TextInput style={styles.input} 
            onChangeText={(message) => setMessage(message)} 
          />
        </View>
        
        <TouchableOpacity onPress={showAlert} style={styles.btnSend}>
          <Text style={{backgroundColor: "#ED213A", color: 'white', padding: 10, marginTop: 20}}>Send email</Text>
        </TouchableOpacity>

        {status !== null &&
          <View style={{borderWidth: 2, borderColor: 'black', margin:20, padding: 10}}>
            <Text>{status}</Text>
          </View>
        }
        <StatusBar style="auto" />
      </View>

  );
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },

  textLabel: {
    fontSize: 16,
    color: 'red',
    fontWeight: "bold",
    marginTop: 35
  },

  input: {
    color: "black",
    fontSize: 16,
    borderBottomWidth : 1.0,
    padding: 4,
    marginTop: 8,
    width: 220
  },

  btnCheck: {
    backgroundColor: "#ED213A",
    position: "absolute",
    top: 154,
    left: 235,
    borderWidth:1,
    borderColor: "#ED213A",
    alignItems: 'center',
    justifyContent: 'center',
    width: 40,
    height: 40,
    borderRadius: 40,
    color: 'white'
  }
});