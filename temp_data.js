function temp_data()
{
var d = Document.type.value;
console.log(d);
Document.myform.action='ControlServlet?type=d';
}