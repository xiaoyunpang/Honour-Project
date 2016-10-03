from urllib2 import urlopen
import urllib2
from bs4 import BeautifulSoup
import lxml
import string
import csv

def parse_contents(html):
	return filter(lambda x: not(x.strip() == ''), html.encode('ascii','ignore').replace('\t', '').splitlines())


writer = csv.writer(open('data/award-datails.csv', 'a'))
writer.writerow(['Research Title', 'Competition Year', 'Fiscal Year', 'Project Lead Name', 'Institution',
				 'Department', 'Province', 'Award Amount', 'Installment', 'Program', 'Selection Committee',
				 'Research Subject', 'Area of Application', 'Co-Researchers', 'Partners', 'Award Summary'])
for num in range(1, 592608):
	link = "http://www.nserc-crsng.gc.ca/ase-oro/Details-Detailles_eng.asp?id=" + str(num)
	try:
		html = urlopen(link)
		bsObj = BeautifulSoup(html, 'lxml')
		form = bsObj.find("div", {"id": "main-container-1col"})
		raw_data = parse_contents(form.text)
		name = raw_data.pop(0)
		final_data = map(lambda x: x.strip(), [name] + raw_data[::2][1:])
		writer.writerow(final_data)
	except urllib2.HTTPError, error:
		print num